
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
  ,RJ(11,"J","Jack")
  ,RQ(12,"Q","Queen")
  ,RK(13,"K","King")
  ,RA(14,"A","Ace")
  
  int value
  String shortCode
  String display

  Rank(value,shortCode){
    this.value = value
    this.shortCode = shortCode
    this.display = this.shortCode // default it to the shortCode
  }

    
  Rank(value,shortCode,display){
    this.value = value
    this.shortCode = shortCode
    this.display = display
  }
}
