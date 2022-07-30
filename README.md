# native-date-picker-module

Native module for date & time picker which opens picker dialog and let's you select date or time.

## Inatallation

```
npm i native-date-picker-module
```

## Usage

```jsx
import * as React from 'react';

import { StyleSheet, View, Button } from 'react-native';
import { DateTimePicker } from 'native-date-picker-module';

export default function App() {
  const showDatePicker = async () => {
    const result = await DateTimePicker.open({
      mode: 'date',
    });
    console.log(result);
  };

  const showTimePicker = async () => {
    const result = await DateTimePicker.open({
      mode: 'time',
      is24HoursView: false,
    });
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
```

## `DateTimePicker` native module

- `DateTimePicker.open({})` will open picker.

### Props

- mode: `date` or `time`
- is24HoursView: Used to show 24 hours view for time picker
- colorMode: `light` or `dark`
- pickerTheme: `default` or `spinner`

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
