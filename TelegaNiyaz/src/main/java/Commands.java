public enum Commands {

 start ("/start") ,
 help ("/help") ;

 private String title;

 Commands(String title ){
  this.title = title;
 }

 public String getTitle(){
  return this.title;
 }


 @Override
 public String toString() {
  return this.title;
 }
}
