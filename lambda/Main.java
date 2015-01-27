
// spyy


interface IntegerMath
{
   void operation(int a, int b);   
   
}



class Lambda
{ 
   public static void main( String[] not_in_use )
   {
       
       IntegerMath func = (a, b) -> System.out.println( Integer.toString(a + b) ) ;
       
       func.operation(2, 4);
       
   }
}