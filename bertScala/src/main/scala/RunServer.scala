/**
  * Created by Alex on 02/02/2019.
  */

import akka.actor.ActorSystem
import colossus.core.IOSystem
import colossus.protocols.http.{HttpServer, Initializer}
import com.google.inject.{Guice, Injector}

object RunServer {

  implicit val actorSystem: ActorSystem = ActorSystem()
  implicit val ioSystem: IOSystem = IOSystem()

  private val port: Int = System.getProperty("port", "8080").toInt
  private val modelPath: String = System.getProperty("model_path", "/Users/alexkim/git/bertBurner")
  private val libraryPath: String = System.getProperty("lib_path", "/Users/alexkim/git/bertBurner")
//  System.load(s"${libraryPath}/libModel.so")
  System.load(s"${libraryPath}/libModel.dylib")

  private val injector: Injector = Guice.createInjector()
  private val runEval: RunEval = injector.getInstance(classOf[RunEval])
  private val evalJNI: EvalJNI = injector.getInstance(classOf[EvalJNI])
  private val modelP: Long = evalJNI.loadModel(s"${modelPath}/scripted_model.pth")

  def main(args: Array[String]): Unit = {
    println(s"serverStart\u241Btimestamp=${System.currentTimeMillis()}\u241BmodelPointer=${modelP}")

    HttpServer.start("burner", port){initContext =>
      new Initializer(initContext) {
        override def onConnect: RequestHandlerFactory = serverContext => {
          new ManageRequest(serverContext, runEval, modelP)
        }
      }
    }
  }

}