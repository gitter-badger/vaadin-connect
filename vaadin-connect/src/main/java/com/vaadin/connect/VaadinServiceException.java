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

public class VaadinServiceException extends RuntimeException {
  private final Object details;

  public VaadinServiceException(String message) {
    super(message);
    this.details = null;
  }

  public VaadinServiceException(String message, Object details) {
    super(message);
    this.details = details;
  }

  public VaadinServiceException(Throwable cause) {
    super(cause);
    this.details = null;
  }

  public VaadinServiceException(Throwable cause, Object details) {
    super(cause);
    this.details = details;
  }

  public VaadinServiceException(String message, Throwable cause) {
    super(message, cause);
    this.details = null;
  }

  public VaadinServiceException(String message, Throwable cause,
      Object details) {
    super(message, cause);
    this.details = details;
  }

  public Object getDetails() {
    return details;
  }
}
