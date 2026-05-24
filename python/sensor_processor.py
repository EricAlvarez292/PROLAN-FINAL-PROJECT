sensor_data = [
    "SENSOR-A1",  82.5,
    "SENSOR-B2",  45.0,
    "SENSOR-C3",  91.3,
    "SENSOR-D4",  60.7,
    "SENSOR-E5",  78.1,
    "SENSOR-F6",  33.4,
    "SENSOR-G7",  88.9,
    "SENSOR-H8",  55.2,
    "SENSOR-I9",  76.0,
    "SENSOR-J10", 42.8,
]

THRESHOLD = 75.0

current_id = None
total      = 0.0
count      = 0
highest    = float("-inf")

separator = "+---------------+----------+----------+"
print(separator)
print(f"| {'ID':<13} | {'Reading':>8} | {'Status':<8} |")
print(separator)

for item in sensor_data:

    if type(item) == str:
        current_id = item

    elif type(item) == float or type(item) == int:
        reading = float(item)

        total += reading
        count += 1

        if reading > highest:
            highest = reading

        status = "CRITICAL" if reading > THRESHOLD else "NORMAL"

        print(f"| {current_id:<13} | {reading:>8.1f} | {status:<8} |")

print(separator)

if count > 0:
    average = total / count
    print(f"\n  Average Reading : {average:.2f}")
    print(f"  Highest Reading : {highest:.2f}")
