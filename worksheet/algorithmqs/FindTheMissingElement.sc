object FindTheMissingElement {

  /*
    Question: First list consists of non-negative integers.
    A second list is formed by shuffling first list and deleting few random elements.
    Given these two list, find which element is missing in the second list.
   */

  //solution:
  def run(l1: List[Int], l2: List[Int]): Unit = {
    val list2 = l2.sorted

    val (missingElements, _) = l1.sorted.foldLeft(List[Int](), 0) { case ((missingElements, index), firstListElement) =>

      if(index < list2.length) {
        if (firstListElement == list2(index))
          (missingElements, index + 1)
        else if (firstListElement < list2(index))
          (firstListElement :: missingElements, index)
        else
          (firstListElement :: missingElements, index + 1)
      }
      else {
        (firstListElement :: missingElements, index)
      }
    }

    println(s"FindTheMissingElement:- ${missingElements.mkString(",")}")
  }
}

val list1 = List(1,2,9,4,5,6,7,3)
val list2 = List(3,7,2,1,4,6)

FindTheMissingElement.run(list1, list2)
