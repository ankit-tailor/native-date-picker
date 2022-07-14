import * as React from 'react';

import {
  StyleSheet,
  View,
  Text,
  Button,
  requireNativeComponent,
} from 'react-native';
import { multiply, getDatePicker } from 'date-picker-native-module';

export default function App() {
  const DatePicker = requireNativeComponent('PickerView');

  return (
    <View style={styles.container}>
      <DatePicker
        style={{ width: '100%', height: 100 }}
        // text={'Setting a text on a Custom Native Android View'}
        buttonText={'This is button text'}
      />
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
