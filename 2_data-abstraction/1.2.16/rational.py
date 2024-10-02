import math

class Rational:
    def __init__(self, numerator, denominator):
        if denominator == 0:
            raise ValueError("Denominator cannot be zero.")
        
        gcd = math.gcd(numerator, denominator)
        self.numerator = numerator // gcd
        self.denominator = denominator // gcd
# handle if demoniator is negative
        if self.denominator < 0:
            self.numerator = -self.numerator
            self.denominator = -self.denominator
    
    def __eq__(self, other):
        return (self.numerator == other.numerator and 
                self.denominator == other.denominator)
    
    def __str__(self):
        return f"{self.numerator}/{self.denominator}"

