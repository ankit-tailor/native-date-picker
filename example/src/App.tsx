import * as React from 'react';

import { StyleSheet, View, Button } from 'react-native';
import { DateTimePicker } from 'native-date-picker-module';

export default function App() {
  const showDatePicker = async () => {
    const result = await DateTimePicker.open({ mode: 'date' });
    console.log(result);
  };

  const showTimePicker = async () => {
    const result = await DateTimePicker.open({ mode: 'time' });
    console.log(result);
  };

  return (
    <View style={styles.container}>
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
