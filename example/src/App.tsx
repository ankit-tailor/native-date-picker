import * as React from 'react';

import {
  StyleSheet,
  View,
  Text,
  Button,
  // requireNativeComponent,
} from 'react-native';
import { getDatePicker } from 'date-picker-native-module';

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

  const [date, setDate] = React.useState<Date | null>(null);

  React.useEffect(() => {
    const day = parseInt(result.day);
    const month = parseInt(result.month);
    const year = parseInt(result.year);
    const date = new Date(year, month, day);
    console.log(date, '####');
    setDate(date);
  }, [result]);

  return (
    <View style={styles.container}>
      <Text>Selected date: {`${date?.toLocaleDateString()}`}</Text>
      <Button
        title="Click me"
        onPress={async () => {
          const result = await getDatePicker();
          console.log(result, '@@@');
          setResult(result);
        }}
      />
      {/* <DatePicker
        style={{ width: '100%', height: 100 }}
        // text={'Setting a text on a Custom Native Android View'}
        buttonText={'This is button text'}
      /> */}
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
