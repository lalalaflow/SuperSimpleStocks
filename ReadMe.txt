### How to run
- Run main method in TradeEnterance class.

### Workflow 
TradeFlow.pdf

### Assumptions
- System works for one stock at once

- The punctuation(.) of “Fixed Dividend .Par Value” in the formula for "Dividend Yield" calculation of Preferred type : Multiplication.

- The calculation order of "Σ Traded Pricei × Quantityi” in the formula for "Volume Weighted Stock Price" : 
For given index,
first, multiply (Traded Price × Quantity)
second, add all the results.
Reference - https://books.google.co.uk/books?id=aaY8AAAAIAAJ&pg=PA187&lpg=PA187&dq=sigma+multiplication+priority&source=bl&ots=b0jQ6mMEEB&sig=OsuIXuVIdq5yRDu3ol5roL3q-lM&hl=en&sa=X&ved=0ahUKEwjU4PW6lJvMAhVItRoKHb5MBnUQ6AEIIjAB#v=onepage&q=sigma%20multiplication%20priority&f=false

- Data type for Price : BigDecimal (Concerns - slow)
One of the references
http://www.javapractices.com/topic/TopicAction.do?Id=13

- The Stock is distinguished by Stock Symbol which means the system take Stock Symbol is a unique value for stock.

- Past 15 minutes means between the current recording time and the last 15 minutes; The current recording will be the latest history


### Decision
- Added Stock Symbol for a stock trade record.

- Dividend value for P/E Ratio means "Last Dividend"


### Environment
Java 1.8
Junit 3.8.1
Maven 3.8
IDE - IntelliJ 15


### Reference
- BigDecimal (Java API doc)
https://docs.oracle.com/javase/8/docs/api/java/math/BigDecimal.html



### TODO
- Catch exception
- Comments
- Write Test cases with various scenarios
