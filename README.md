# date-picker-native-module

native module for date picker

## Installation

```sh
npm install date-picker-native-module
```

## Usage

```jsx
import * as React from 'react';

import {
  StyleSheet,
  View,
  Text,
  Button,
} from 'react-native';
import { getDatePicker } from 'date-picker-native-module';

export default function App() {
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
    setDate(date);
  }, [result]);

  return (
    <View style={styles.container}>
      <Text>Selected date: {`${date?.toLocaleDateString()}`}</Text>
      <Button
        title="Click me"
        onPress={async () => {
          const result = await getDatePicker();
          setResult(result);
        }}
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
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
