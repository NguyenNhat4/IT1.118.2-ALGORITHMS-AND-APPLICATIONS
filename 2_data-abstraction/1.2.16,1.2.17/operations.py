from rational import Rational

def plus(a: Rational, b: Rational) -> Rational:
    new_numerator = a.numerator * b.denominator + b.numerator * a.denominator
    new_denominator = a.denominator * b.denominator
    return Rational(new_numerator, new_denominator)

def minus(a: Rational, b: Rational) -> Rational:
    new_numerator = a.numerator * b.denominator - b.numerator * a.denominator
    new_denominator = a.denominator * b.denominator
    return Rational(new_numerator, new_denominator)

def times(a: Rational, b: Rational) -> Rational:
    new_numerator = a.numerator * b.numerator
    new_denominator = a.denominator * b.denominator
    return Rational(new_numerator, new_denominator)

def divides(a: Rational, b: Rational) -> Rational:
    if b.numerator == 0:
        raise ValueError("Cannot divide by zero.")
    
    new_numerator = a.numerator * b.denominator
    new_denominator = a.denominator * b.numerator
    return Rational(new_numerator, new_denominator)
