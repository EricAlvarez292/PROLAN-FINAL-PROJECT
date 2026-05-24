from industrial_asset import IndustrialAsset

class ElectronicSensor(IndustrialAsset):

    def __init__(self, name, serial_number, base_value, voltage, current_reading):
        super().__init__(name, serial_number, base_value)   # reuse parent __init__
        self.__voltage         = voltage
        self.__current_reading = current_reading

    @property
    def voltage(self):
        return self.__voltage

    @voltage.setter
    def voltage(self, value):
        self.__voltage = value

    @property
    def current_reading(self):
        return self.__current_reading

    @current_reading.setter
    def current_reading(self, value):
        self.__current_reading = value

    def calibrate(self, new_reading):
        self.__current_reading = new_reading
        print(f"  [Calibrated] {self.name} -> New Reading: {new_reading}")

    def display_specs(self):
        super().display_specs()
        print(f"  Voltage       : {self.__voltage:.1f} V")
        print(f"  Reading       : {self.__current_reading:.2f}")
