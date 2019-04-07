/**
  * Created by alex on 15/01/2019
  */

import javax.inject.Singleton

@Singleton
class EvalJNI {

  @native def loadModel(modelName: String): Long
  @native def evaluate(pModel: Long, x: Array[Long], xSize: Int): Array[Float]

}