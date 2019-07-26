/**
  * Created by Alex on 03/02/2019.
  */

import burner.EvalJNI
import javax.inject.{Inject, Singleton}

@Singleton
class RunEval @Inject()(evalJNI: EvalJNI) {

  def apply(inputVector: List[Long], modelP: Long): String = {
      evalJNI.evaluate(modelP, inputVector.toArray, inputVector.length).map(x => f"${x}%1.8f").mkString(",")
  }

}