

object fibo {
  def  fibo(n : Int) : Int = {
       if (n == 1 || n == 0){
          1;
       } else {
          fibo(n -1) + fibo(n - 2);
       }
  }
};