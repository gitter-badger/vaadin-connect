/*
 * Copyright 2000-2019 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vaadin.connect;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * A checker responsible for validating the Vaadin Connect service names.
 */
public class VaadinServiceNameChecker {
  /**
   * Set of reserved words in ECMAScript specification.
   *
   * @see <a href=
   *      "https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Lexical_grammar#Keywords">Specification</a>
   */
  public static final Set<String> ECMA_SCRIPT_RESERVED_WORDS = Collections
      .unmodifiableSet(new HashSet<>(Arrays.asList("abstract", "arguments",
          "await", "boolean", "break", "byte", "case", "catch", "char", "class",
          "const", "continue", "debugger", "default", "delete", "do", "double",
          "else", "enum", "eval", "export", "extends", "false", "final",
          "finally", "float", "for", "function", "goto", "if", "implements",
          "import", "in", "instanceof", "int", "interface", "let", "long",
          "native", "new", "null", "package", "private", "protected", "public",
          "return", "short", "static", "super", "switch", "synchronized",
          "this", "throw", "throws", "transient", "true", "try", "typeof",
          "var", "void", "volatile", "while", "with", "yield")));

  private static final Pattern CONTAINS_WHITESPACE_PATTERN = Pattern
      .compile(".*[\\s+].*");

  /**
   * Validates the Vaadin Connect service name given.
   *
   * @param serviceName
   *          the name to validate
   * @return {@code null} if there are no validation errors or {@link String}
   *         containing validation error description.
   */
  public String check(String serviceName) {
    if (serviceName == null || serviceName.isEmpty()) {
      return "Service name cannot be blank";
    }
    if (ECMA_SCRIPT_RESERVED_WORDS.contains(serviceName)) {
      return "Service name cannot be equal to JavaScript reserved words";
    }
    if (CONTAINS_WHITESPACE_PATTERN.matcher(serviceName).matches()) {
      return "Service name cannot contain any whitespaces";
    }
    return null;
  }
}
