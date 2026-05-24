from industrial_asset import IndustrialAsset
from electronic_sensor import ElectronicSensor
from sensor_failure_exception import SensorFailureException
from sensor_utils import calculate_efficiency, filter_critical
from report_writer import write_report

print("=== Data Ingestion ===")
raw_readings = ["82.3", "bad_data", "-300.0", "55.0"]

for raw in raw_readings:
    try:
        reading = float(raw)
        if reading < 0:
            raise SensorFailureException(f"Impossible reading: {reading}")
        print(f"  Accepted : {reading}")
    except ValueError:
        print(f"  [ValueError] Non-numeric input: {raw}")
    except SensorFailureException as e:
        print(f"  [SensorFailureException] {e}")
    finally:
        print("  -> Ingestion attempt complete.\n")

assets = [
    IndustrialAsset("Control Panel",      "SN-100", 5000.00),
    ElectronicSensor("Pressure Sensor",   "SN-001", 1200.00, 24.0, 82.3),
    ElectronicSensor("Temp Sensor",       "SN-002",  800.00, 12.0, 55.0),
    IndustrialAsset("Conveyor Belt Unit", "SN-101", 3200.00),
]

print("=== Efficiency Report ===")
for asset in assets:
    if isinstance(asset, ElectronicSensor):
        eff = calculate_efficiency(asset.current_reading, 100.0)
        print(f"  {asset.name:<20} | Efficiency: {eff:.1f}%")

critical = filter_critical(assets)
print("\n=== Critical Sensors ===")
for s in critical:
    print(f"  {s.name} | Reading: {s.current_reading}")

print()
write_report("report.txt", assets)
