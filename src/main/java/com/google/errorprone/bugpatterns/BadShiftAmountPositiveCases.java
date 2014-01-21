/*
 * Copyright 2013 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.errorprone.bugpatterns;

/**
 * @author Bill Pugh (bill.pugh@gmail.com)
 */
public class BadShiftAmountPositiveCases {
  
  public void foo() {
    int x = 0;
    long result = 0;

    //BUG: Suggestion includes "(long) x >> 32"
    result += x >> 32;
    //BUG: Suggestion includes "(long) x << 32"
    result += x << 32;
    //BUG: Suggestion includes "(long) x >>> 32"
    result += x >>> 32;
    //BUG: Suggestion includes "(long) x >> 40"
    result += x >> 40;
    //BUG: Suggestion includes "(long) (x & 255) >> 40"
    result += (x & 255) >> 40;
    
    //BUG: Suggestion includes "1L << 48"
    result += 1 << 48;
    
    //BUG: Suggestion includes "x >> 4"
    result += x >> 100;
    //BUG: Suggestion includes "x >> 31"
    result += x >> -1;
    
    byte b = 0;
    char c = 'a';
    
    //BUG: Suggestion includes "(long) b >> 32"
    result += b >> 32;
    //BUG: Suggestion includes "(long) b << 32"
    result += b << 32;
    //BUG: Suggestion includes "(long) c >> 32"
    result += c >> 32;
    //BUG: Suggestion includes "(long) c >>> 32"
    result += c >>> 32;
  }
  
}
