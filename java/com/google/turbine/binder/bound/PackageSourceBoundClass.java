/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.turbine.binder.bound;

import com.google.common.collect.ImmutableMap;
import com.google.turbine.binder.lookup.CompoundScope;
import com.google.turbine.binder.sym.ClassSymbol;
import com.google.turbine.model.TurbineTyKind;
import com.google.turbine.tree.Tree;

/** A {@link BoundClass} with shared lookup scopes for the current compilation unit and package. */
public class PackageSourceBoundClass implements BoundClass {
  private final SourceBoundClass base;
  private final CompoundScope scope;

  public PackageSourceBoundClass(SourceBoundClass base, CompoundScope scope) {
    this.base = base;
    this.scope = scope;
  }

  public Tree.TyDecl decl() {
    return base.decl();
  }

  @Override
  public TurbineTyKind kind() {
    return base.kind();
  }

  @Override
  public ClassSymbol owner() {
    return base.owner();
  }

  @Override
  public ImmutableMap<String, ClassSymbol> children() {
    return base.children();
  }

  public CompoundScope scope() {
    return scope;
  }
}