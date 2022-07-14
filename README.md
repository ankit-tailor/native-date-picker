# date-picker-native-module

native module for date picker

## Installation

```sh
npm install date-picker-native-module
```

## Usage

```js
import * as React from 'react';

import { StyleSheet, View, requireNativeComponent } from 'react-native';

export default function App() {
  const DatePicker = requireNativeComponent('PickerView');

  return (
    <View style={styles.container}>
      <DatePicker />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
});
```

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT

---

Made with [create-react-native-library](https://github.com/callstack/react-native-builder-bob)
