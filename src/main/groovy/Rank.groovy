
enum Rank {
  R2(2,"2")
  ,R3(3,"3")
  ,R4(4,"4")
  ,R5(5,"5")
  ,R6(6,"6")
  ,R7(7,"7")
  ,R8(8,"8")
  ,R9(9,"9")
  ,R10(10,"10")
  ,RJ(11,"J")
  ,RQ(12,"Q")
  ,RK(13,"K")
  ,RA(14,"A")
  
  int value
  String display
  
  Rank(value,display){
    this.value = value
    this.display = display
  }
}
