@objc(DatePickerNativeModule)
class DatePickerNativeModule: NSObject {

  @objc(multiply:withB:withResolver:withRejecter:)
  func multiply(a: Float, b: Float, resolve:RCTPromiseResolveBlock,reject:RCTPromiseRejectBlock) -> Void {
    resolve(a*a+b*b+2*a*b)
  }
}
