from industrial_asset import IndustrialAsset
from electronic_sensor import ElectronicSensor

pressure_sensor = ElectronicSensor("Pressure Sensor", "SN-001", 1200.00, 24.0, 68.5)
pressure_sensor.calibrate(82.3)

assets = [
    IndustrialAsset("Control Panel",      "SN-100", 5000.00),
    pressure_sensor,
    ElectronicSensor("Temp Sensor",       "SN-002",  800.00, 12.0, 55.0),
    IndustrialAsset("Conveyor Belt Unit", "SN-101", 3200.00),
]

print()

for asset in assets:
    print("------------------------------")
    asset.display_specs()
print("------------------------------")
