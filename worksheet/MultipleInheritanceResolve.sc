
//This example explain how scala tames multiple inheritance.

trait A{
  def a = 1
}

trait X extends A{
  override def a = {
    println("X")
    super.a
  }
}

trait B extends X{
  override def a = {
    println("B")
    super.a
  }
}

trait Y extends A{
  override def a = {
    println("Y")
    super.a
  }
}


trait Z extends Y{
  override def a = {
    println("ZY")
    super.a
  }
}

val xy = new AnyRef with X with Z with B with Y

xy.a

//with X resolved as this sequence ->  A X
//with Z resolved as this sequence->  A Y Z
//with B resolved as this sequence->   A X B
//with Y resolved as this sequence->   A Y
//Now start from left pick class without repeating
//A X Y Z B
