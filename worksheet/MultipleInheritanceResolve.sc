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
//https://blog.safaribooksonline.com/2013/05/30/traits-how-scala-tames-multiple-inheritance/
//Traits: How Scala Tames Multiple Inheritance
//with X resolved as ->  A X
//with Z resolved as ->  A Y Z
//with B resolved as ->   A X B
//with Y resolved as ->   A Y
//Now start from left pick class without repeating
//A X Y Z B
