export type DatePickerType = {
  mode: 'date' | 'time';
  is24HoursView: boolean;
  setMaxDate: number | Date;
  setMinDate: number | Date;
  pickerTheme: 'default' | 'spinner';
  colorMode: 'dark' | 'light';
};
