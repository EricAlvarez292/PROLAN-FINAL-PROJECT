class IndustrialAsset:

    def __init__(self, name, serial_number, base_value):
        self.__name          = name
        self.__serial_number = serial_number
        self.__base_value    = base_value

    @property
    def name(self):
        return self.__name

    @name.setter
    def name(self, value):
        self.__name = value

    @property
    def serial_number(self):
        return self.__serial_number

    @serial_number.setter
    def serial_number(self, value):
        self.__serial_number = value

    @property
    def base_value(self):
        return self.__base_value

    @base_value.setter
    def base_value(self, value):
        self.__base_value = value

    def display_specs(self):
        print(f"  Name          : {self.__name}")
        print(f"  Serial Number : {self.__serial_number}")
        print(f"  Base Value    : ${self.__base_value:.2f}")
