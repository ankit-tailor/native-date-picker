export const CONSTANTS = {
  DEFAULT: 'default',
  SPINNER: 'spinner',
  INPUT: 'input',
  LIGHT: 'light',
  DARK: 'dark',
};

export const getTimePickerTheme = (pickerTheme: string, colorMode: string) => {
  if (colorMode === CONSTANTS.LIGHT) {
    switch (pickerTheme) {
      case CONSTANTS.SPINNER:
        return 3;
      default:
        return 0;
    }
  } else {
    switch (pickerTheme) {
      case CONSTANTS.SPINNER:
        return 2;
      default:
        return 4;
    }
  }
};

export const getDatePickerTheme = (pickerTheme: string, colorMode: string) => {
  if (colorMode === CONSTANTS.LIGHT) {
    switch (pickerTheme) {
      case CONSTANTS.SPINNER:
        return 3;
      default:
        return 0;
    }
  } else {
    switch (pickerTheme) {
      case CONSTANTS.SPINNER:
        return 2;
      default:
        return 4;
    }
  }
};
