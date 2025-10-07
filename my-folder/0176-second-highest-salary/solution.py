import pandas as pd

def second_highest_salary(employee: pd.DataFrame) -> pd.DataFrame:
    # Use the correct variable name: 'employee'
    unique_salaries = employee['salary'].drop_duplicates().sort_values(ascending=False)
    
    # Check if a second highest salary exists
    if len(unique_salaries) >= 2:
        second_highest = unique_salaries.iloc[1]
    else:
        second_highest = None  # Pandas will show None as NaN (similar to SQL NULL)
    
    # Return the result as a DataFrame
    return pd.DataFrame({'SecondHighestSalary': [second_highest]})

