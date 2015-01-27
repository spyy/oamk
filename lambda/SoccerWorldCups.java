//  LambdaExpressionsDemo2.java  by Kari Laitinen

//  http://www.naturalprogramming.com

//  2014-11-09  File created.
//  2014-11-09  Last modification.

/*  This program is a slightly modified version of a program in
    https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html

    Requires JDK 8 or later.
*/

interface IntegerMath
{
   int operation(int a, int b);   
}


class Calculator
{
   public int calculate( int left_operand,
                         int right_operand,
                         IntegerMath operator )
   {
      return operator.operation( left_operand, right_operand ) ;
   }
}

class Lambda
{ 
   public static void main( String... not_in_use )
   {
      Calculator calculator = new Calculator() ;

      // Next we assign lambda expressions as values to two 'variables'
      // -> is called the arrow token in a lambda expression

      IntegerMath addition = (a, b) -> a + b ;

      IntegerMath subtraction = (a, b) -> a - b ;

      System.out.print("\n\n   40 + 2 = " +
            calculator.calculate( 40, 2, addition ) ) ;

      System.out.print("\n\n   20 - 11 = " +
            calculator.calculate( 20, 11, subtraction ) + "\n\n" ) ;    
   }
}