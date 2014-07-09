
enum Rank{

  R2("2")
  ,R3("3")
  ,R4("4")
  ,R5("5")
  ,R6("6")
  ,R7("7")
  ,R8("8")
  ,R9("9")
  ,R10("10")
  ,RJ("J","Jack") 
  ,RQ("Q","Queen")
  ,RK("K","King")
  ,RA("A","Ace")

  String shortCode
  String display

  Rank(shortCode){
    this.shortCode = shortCode
    this.display = this.shortCode // default it to the shortCode
  }

    
  Rank(shortCode,display){
    this.shortCode = shortCode
    this.display = display
  }
  
}
