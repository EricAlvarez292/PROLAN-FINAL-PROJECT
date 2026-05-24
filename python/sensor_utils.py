from electronic_sensor import ElectronicSensor

def calculate_efficiency(reading, max_scale):
    efficiency = (reading / max_scale) * 100.0
    return efficiency


def filter_critical(assets):
    is_critical = lambda a: isinstance(a, ElectronicSensor) and a.current_reading > 75.0
    return list(filter(is_critical, assets))
