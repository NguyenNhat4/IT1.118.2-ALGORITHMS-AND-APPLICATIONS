from rational import Rational
import operations as ops

if __name__ == "__main__":
    r1 = Rational(1, 2)
    r2 = Rational(1, 3)
    
    print(f"r1 + r2 = {ops.plus(r1, r2)}")
    print(f"r1 - r2 = {ops.minus(r1, r2)}") 
    print(f"r1 * r2 = {ops.times(r1, r2)}")  
    print(f"r1 / r2 = {ops.divides(r1, r2)}")  
