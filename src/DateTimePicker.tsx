import { NativeModules, Platform } from 'react-native';
import type { DatePickerType } from './types';
import { CONSTANTS, getTimePickerTheme } from './utils';

const { NativeDatePicker } = NativeModules;

const LINKING_ERROR =
  `The package 'native-date-picker-module' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const NativeDatePickerModule = NativeDatePicker
  ? NativeDatePicker
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

function open(props: Partial<DatePickerType>) {
  const {
    mode = 'date',
    is24HoursView = true,
    colorMode = CONSTANTS.DARK,
    pickerTheme = CONSTANTS.DEFAULT,
  } = props;

  if (mode === 'date') {
    return NativeDatePickerModule.getDatePicker(
      getTimePickerTheme(pickerTheme, colorMode)
    );
  } else {
    return NativeDatePickerModule.getTimePicker(
      is24HoursView,
      colorMode,
      getTimePickerTheme(pickerTheme, colorMode)
    );
  }
}

export const DateTimePicker = { open };
