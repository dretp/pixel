import csv

with open('NCHS_-_Death_rates_and_life_expectancy_at_birth.csv') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            print(f'Column names are {", ".join(row)}')
            line_count += 1
        else:
            print(f'\t year: {row[0]} Race: {row[1]} Sex: {row[2]}. avgLife: {row[3]}')
            line_count += 1
    print(f'Processed {line_count} lines.')