

 
Listing 21-1 An interface for the ADT stack

public interface
    StackInterface < T >
{
    /** Task: Adds a new entry to the top of the stack.
    * @param newEntry an object to be added to the stack */
    public void
        push (T newEntry);
    /** Task: Removes and returns the stacks top entry.
    * @return either the object at the top of the stack or, if the
    * stack is empty before the operation, null */
    public
        T pop ();
    /** Task: Retrieves the stacks top entry.
    * @return either the object at the top of the stack or null if
    * the stack is empty */
    public
        T peek ();
    /** Task: Detects whether the stack is empty.
    * @return true if the stack is empty */
    public boolean
        isEmpty ();
    /** Task: Removes all entries from the stack */
    public void
        clear ();
} // end StackInterface

 

 

 
Algorithm to check proper pairing of  ( ), { }, and [ ]

Algorithm checkBalance (expression)
    // Returns true if the parentheses, brackets, and braces in an expression are paired correctly.
    isBalanced = true
    while ((isBalanced == true) and not at end of expression)
{
    nextCharacter = next character in expression
        switch (nextCharacter)
    {
        case '(':
        case '[':
        case '{':
            Push nextCharacter onto stack
            break
            
            case ')':
            case ']':
            case '}':
                if (stack is empty)
                    isBalanced = false
                 else
                {
                    openDelimiter = top entry of stack
                    Pop stack
                    isBalanced = true or false according to whether openDelimiter and
                    nextCharacter are a pair of delimiters
                }
                break
    }
}
if (stack is not empty)
    isBalanced = false
        return isBalanced

 

 

 
Listing 21-2 The class BalanceChecker

public class BalanceChecker
{
    /** Task: Decides whether the parentheses, brackets, and braces
    * in a string occur in left/right pairs.
    * @param expression a string to be checked
    * @return true if the delimiters are paired correctly */
    public static boolean checkBalance (String expression)
    {
        StackInterface < Character > openDelimiterStack =
            new LinkedStack < Character > ();
        int characterCount = expression.length ();
        boolean isBalanced = true;
        int index = 0;
        char nextCharacter = ' ';
        for (; isBalanced && (index < characterCount) ; index++)
        {
            nextCharacter = expression.charAt (index);
            switch (nextCharacter)
            {
                case '(':
                case '[':
                case '{':
                    openDelimiterStack.push (nextCharacter);
                    break;
                case ')':
                case ']':
                case '}':
                    if (openDelimiterStack.isEmpty ())
                        isBalanced = false;
                    else
                    {
                        char openDelimiter = openDelimiterStack.pop ();
                        isBalanced = isPaired (openDelimiter, nextCharacter);
                    } // end if
                    break;
                default:
                    break;
            } // end switch
        } // end for
        if (!openDelimiterStack.isEmpty ())
            isBalanced = false;
        return isBalanced;
    } // end checkBalance


    /** Task: Detects whether two delimiters are a pair of
    * parentheses, brackets, or braces.
    * @param open a character
    * @param close a character
    * @return true if open/close form a pair of parentheses, brackets,
    * or braces */
    private static boolean isPaired (char open, char close)
    {
        return (open == '(' && close == ')') ||
            (open == '[' && close == ']') ||
            (open == '{' && close == '}');
    } // end isPaired
} // end BalanceChecker

 

 

 
Algorithm for converting an infix  expression to equivalent postfix

Algorithm convertToPostfix (infix)
    // Converts an infix expression to an equivalent postfix expression.
    operatorStack = a new empty stack
    postfix = a new empty string
    while (infix has characters left to parse)
{
    nextCharacter = next nonblank character of infix
        switch (nextCharacter)
    {
        case variable:
            Append nextCharacter to postfix
                break
                case '^':
                    operatorStack.push (nextCharacter)
                    break
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!operatorStack.isEmpty () and
                        precedence of nextCharacter <= precedence of operatorStack.peek ())
                    {
                        Append operatorStack.peek () to postfix
                        operatorStack.pop ()
                    }
                    operatorStack.push (nextCharacter)
                    break
                case '( ':
                    operatorStack.push (nextCharacter)
                    break
                case ')':  // stack is not empty if infix expression is valid
                    topOperator = operatorStack.pop ()
                    while (topOperator != '(')
                    {
                        Append topOperator to postfix
                        topOperator = operatorStack.pop ()
                    }
                    break
                default:
                    break
    }
}
while (!operatorStack.isEmpty ())
{
    topOperator = operatorStack.pop ()
        Append topOperator to postfix
}
return postfix

 

 

 
Listing 21-3  The class Postfix

public class Postfix
{
    /** Task: Creates a postfix expression that represents a given infix
    * expression.
    * @param infix a string that is a valid infix expression
    * @return a string that is the postfix expression equivalent to
    * infix */
    public static String convertToPostfix (String infix)
    {
        StringBuilder postfix = new StringBuilder ();
        StackInterface < Character > operatorStack =
            new LinkedStack < Character > ();
        int characterCount = infix.length ();
        char topOperator;
        for (int index = 0 ; index < characterCount ; index++)
        {
            boolean done = false;
            char nextCharacter = infix.charAt (index);
            if (isVariable (nextCharacter))
                postfix = postfix.append (nextCharacter);
            else
            {
                switch (nextCharacter)
                {
                    case '^':
                        operatorStack.push (nextCharacter);
                        break;
                    case '+':
                    case '-':
                    case '*':
                    case '/':
                        while (!done && !operatorStack.isEmpty ())
                        {
                            topOperator = operatorStack.peek ();
                            if (getPrecedence (nextCharacter) <=
                                    getPrecedence (topOperator))
                            {
                                postfix = postfix.append (topOperator);
                                operatorStack.pop ();
                            }
                            else
                                done = true;
                        } // end while
                        operatorStack.push (nextCharacter);
                        break;
                    case '(':
                        operatorStack.push (nextCharacter);
                        break;
                    case ')': // stack is not empty if infix expression is valid
                        topOperator = operatorStack.pop ();
                        while (topOperator != '(')
                        {
                            postfix = postfix.append (topOperator);
                            topOperator = operatorStack.pop ();
                        } // end while
                        break;
                    default:
                        break;
                } // end switch
            } // end if
        } // end for
        while (!operatorStack.isEmpty ())
        {
            topOperator = operatorStack.pop ();
            postfix = postfix.append (topOperator);
        } // end while
        return postfix.toString ();
    } // end convertToPostfix


    /** Task: Indicates the precedence of a given operator.
    * @param operator a character that is (, ), +, -, *, /, or ^
    * @return an integer that indicates the precedence of operator:
    * 0 if ( or ), 1 if + or -, 2 if * or /, 3 if ^, -1 if
    * anything else */
    private static int getPrecedence (char operator)
    {
        switch (operator)
        {
            case '(':
            case ')':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        } // end switch
        return -1;
    } // end getPrecedence


    private static boolean isVariable (char character)
    {
        return Character.isLetter (character);
    } // end isVariable
} // end Postfix

 

 

 
Algorithm for evaluating postfix expression

Algorithm evaluatePostfix (postfix)
    // Evaluates a postfix expression.
    valueStack = a new empty stack
    while (postfix has characters left to parse)
{
    nextCharacter = next nonblank character of postfix
        switch (nextCharacter)
    {
        case variable:
            valueStack.push (value of the variable nextCharacter)
                break
                case ' + ':
                case ' - ':
                case ' * ':
                case ' / ':
                case ' ^ ':
                    operandTwo = valueStack.pop ()
                    operandOne = valueStack.pop ()
                    result = the result of the operation in nextCharacter and its operands
                    operandOne and operandTwo
                    valueStack.push (result)
                    break
                default:
                    break
    }
}
return valueStack.peek ()

 

 

 
Algorithm for evaluating infix expression

Algorithm evaluateInfix (infix)
    // Evaluates an infix expression.
    operatorStack = a new empty stack
    valueStack = a new empty stack
    while (infix has characters left to process)
{
    nextCharacter = next nonblank character of infix
        switch (nextCharacter)
    {
        case variable:
            valueStack.push (value of the variable nextCharacter)
                break
                case '^':
                    operatorStack.push (nextCharacter)
                    break
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!operatorStack.isEmpty () and
                        precedence of nextCharacter <= precedence of operatorStack.peek ())
                    {
                        // Execute operator at top of operatorStack
                        topOperator = operatorStack.pop ()
                        operandTwo = valueStack.pop ()
                        operandOne = valueStack.pop ()
                        result = the result of the operation in topOperator and its operands
                        operandOne and operandTwo
                        valueStack.push (result)
                    }
                    operatorStack.push (nextCharacter)
                    break
                case '(':
                    operatorStack.push (nextCharacter)
                    break
                case ')':  // stack is not empty if infix expression is valid
                    topOperator = operatorStack.pop ()
                    while (topOperator != '(')
                    {
                        operandTwo = valueStack.pop ()
                        operandOne = valueStack.pop ()
                        result = the result of the operation in topOperator and its operands
                        operandOne and operandTwo
                        valueStack.push (result)
                        topOperator = operatorStack.pop ()
                    }
                    break
                default:
                    break
    }
}
while (!operatorStack.isEmpty ())
{
    topOperator = operatorStack.pop ()
        operandTwo = valueStack.pop ()
        operandOne = valueStack.pop ()
        result = the result of the operation in topOperator and its operands
        operandOne and operandTwo
        valueStack.push (result)
}
return valueStack.peek ()

 

 

 
Methods for using stack instead of recursion

public boolean contains (T anEntry)
{
    return binarySearch (0, length - 1, anEntry);
} // end contains

/** Task: Searches list[first] through list[last] for desiredItem,
* where the array list is a data field.
* @param first an integer index >= 0 and < length of sorted list
* @param last an integer index >= 0 and < length of sorted list
* @param anEntry the object to be found in the array
* @return true if anEntry is found */
private boolean binarySearch (int first, int last, T desiredItem)
{
    boolean found;
    int mid = (first + last) / 2;
    if (first > last)
        found = false;
    else if (desiredItem.equals (list [mid]))
        found = true;
    else if (desiredItem.compareTo (list [mid]) < 0)
        found = binarySearch (first, mid - 1, desiredItem);
    else
        found = binarySearch (mid + 1, last, desiredItem);
    return found;
} // end binarySearch

private class Record
{
    private int first, last;
    private Record (int firstIndex, int lastIndex)
    {
        first = firstIndex;
        last = lastIndex;
    } // end constructor
} // end Record

private boolean binarySearch (int first, int last, T desiredItem)
{
    StackInterface < Record > programStack = new LinkedStack < Record > ();
    boolean found = false;
    boolean done = false;
    programStack.push (new Record (first, last));
    while (!done && !programStack.isEmpty ())
    {
        Record topRecord = programStack.pop ();
        first = topRecord.first;
        last = topRecord.last;
        int mid = (first + last) / 2;
        if (first > last)
        {
            found = false;
            done = true;
        }
        else if (desiredItem.equals (list [mid]))
        {
            found = true;
            done = true;
        }
        else
        {
            if (desiredItem.compareTo (list [mid]) < 0)
                programStack.push (new Record (first, mid - 1));
            else
                programStack.push (new Record (mid + 1, last));
        } // end if
    } // end while


    return found;
} // end binarySearch

 

 

 
Methods for searching, traversing class Stack

/** Task: Searches for a given object in the stack.
* @param desiredItem the object to be found
* @return either the position of desiredItem if it is in the stack
* or -1 if it is not; the top of the stack is at position 1 */
public int search (Object desiredItem);

/** @return an iterator for the stack that conforms to Java's
* interface Iterator */
public Iterator < T > iterator ();

/** @return an iterator for the stack that conforms to Java's
* interface ListIterator */
public ListIterator < T > listIterator ();

 

