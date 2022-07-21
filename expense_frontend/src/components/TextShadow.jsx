import React from 'react';
import {View, Text, StyleSheet} from 'react-native';

const TextShadow = () => {
  return (
    <View style={styles.container}>
      <Text style={styles.text}>Reimbursements </Text>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  text: {
    fontSize: 48,
    textAlign: 'center',
    color: 'white',
    textShadowOffset: {width: 2, height: 2},
    textShadowRadius: 10,
    textShadowColor: 'black',
  },
});

export default TextShadow;