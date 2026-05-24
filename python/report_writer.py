from electronic_sensor import ElectronicSensor
from sensor_utils import calculate_efficiency


def write_report(filename, assets):
    lines = []
    lines.append("INDUSTRIAL ASSET REPORT")
    lines.append("=======================\n")

    for asset in assets:
        lines.append(f"Name          : {asset.name}")
        lines.append(f"Serial Number : {asset.serial_number}")
        lines.append(f"Base Value    : ${asset.base_value:.2f}")

        if isinstance(asset, ElectronicSensor):
            eff = calculate_efficiency(asset.current_reading, 100.0)
            lines.append(f"Voltage       : {asset.voltage:.1f} V")
            lines.append(f"Reading       : {asset.current_reading:.2f}")
            lines.append(f"Efficiency    : {eff:.1f}%")

        lines.append("")

    content = "\n".join(lines)

    # Write to file
    try:
        with open(filename, "w") as f:
            f.write(content)
        print(f"Report saved to: {filename}")
    except IOError as e:
        print(f"[ERROR] Could not write report: {e}")
