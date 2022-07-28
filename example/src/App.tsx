import * as React from 'react';

import {
  StyleSheet,
  View,
  Text,
  Button,
  // requireNativeComponent,
} from 'react-native';
import { DateTimePicker } from 'native-date-picker-module';
// import MessageQueue from 'react-native/Libraries/BatchedBridge/MessageQueue';
// MessageQueue.spy((data) => {
//   // Ignore logs from WebSocketModule
//   if (data.module === 'WebSocketModule') {
//     return;
//   }
//   console.log(data);
// });

export default function App() {
  // const DatePicker = requireNativeComponent('PickerView');
  const [result, setResult] = React.useState<{
    day: string;
    month: string;
    year: string;
  }>({
    day: '',
    month: '',
    year: '',
  });

  // const [date, setDate] = React.useState<Date | null>(null);

  // React.useEffect(() => {
  //   const day = parseInt(result.day);
  //   const month = parseInt(result.month);
  //   const year = parseInt(result.year);
  //   const date = new Date(year, month, day);
  //   console.log(date, '####');
  //   setDate(date);
  // }, [result]);

  const showDatePicker = async () => {
    const result = await DateTimePicker.open({ mode: 'date' });
    console.log(result, '@@@');
    // setResult(result);
  };

  const showTimePicker = async () => {
    const result = await DateTimePicker.open({ mode: 'time' });
    console.log(result, '@@@');
  };

  return (
    <View style={styles.container}>
      {/* <Text>Selected date: {`${date?.toLocaleDateString()}`}</Text> */}
      <Button title="Date Picker" onPress={showDatePicker} />
      <Button title="Time Picker" onPress={showTimePicker} />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
