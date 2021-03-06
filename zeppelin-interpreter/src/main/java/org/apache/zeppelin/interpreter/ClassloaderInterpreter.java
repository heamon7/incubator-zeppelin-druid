/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.zeppelin.interpreter;

import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.apache.zeppelin.scheduler.Scheduler;

/**
 * Add to the classpath interpreters.
 *
 */
public class ClassloaderInterpreter
    extends Interpreter
    implements WrappedInterpreter {

  private ClassLoader cl;
  private Interpreter intp;

  public ClassloaderInterpreter(Interpreter intp, ClassLoader cl) {
    super(new Properties());
    this.cl = cl;
    this.intp = intp;
  }

  @Override
  public Interpreter getInnerInterpreter() {
    return intp;
  }

  public ClassLoader getClassloader() {
    return cl;
  }

  @Override
  public InterpreterResult interpret(String st, InterpreterContext context) {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      return intp.interpret(st, context);
    } catch (InterpreterException e) {
      throw e;
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }


  @Override
  public void open() {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      intp.open();
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public void close() {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      intp.close();
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public void cancel(InterpreterContext context) {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      intp.cancel(context);
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public FormType getFormType() {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      return intp.getFormType();
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public int getProgress(InterpreterContext context) {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      return intp.getProgress(context);
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public Scheduler getScheduler() {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      return intp.getScheduler();
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public List<String> completion(String buf, int cursor) {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      return intp.completion(buf, cursor);
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }


  @Override
  public String getClassName() {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      return intp.getClassName();
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public void setInterpreterGroup(InterpreterGroup interpreterGroup) {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      intp.setInterpreterGroup(interpreterGroup);
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public InterpreterGroup getInterpreterGroup() {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      return intp.getInterpreterGroup();
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public void setClassloaderUrls(URL [] urls) {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      intp.setClassloaderUrls(urls);
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public URL [] getClassloaderUrls() {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      return intp.getClassloaderUrls();
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public void setProperty(Properties property) {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      intp.setProperty(property);
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public Properties getProperty() {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      return intp.getProperty();
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }

  @Override
  public String getProperty(String key) {
    ClassLoader oldcl = Thread.currentThread().getContextClassLoader();
    Thread.currentThread().setContextClassLoader(cl);
    try {
      return intp.getProperty(key);
    } catch (Exception e) {
      throw new InterpreterException(e);
    } finally {
      cl = Thread.currentThread().getContextClassLoader();
      Thread.currentThread().setContextClassLoader(oldcl);
    }
  }
}
