import { NativeModules, Platform } from 'react-native';

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

function open(props: any) {
  const { mode } = props;

  if (mode === 'date') {
    return NativeDatePickerModule.getDatePicker();
  } else {
    return NativeDatePickerModule.getTimePicker();
  }
}

export const DateTimePicker = { open };
