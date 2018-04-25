/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.api.packager;

import static org.mule.tools.api.packager.structure.FolderNames.*;

import java.nio.file.Path;

import org.mule.tools.api.packager.packaging.PackagingType;

/**
 * Generates the basic working folder structure to create a mule application package.
 */
public class MuleProjectFoldersGenerator extends AbstractProjectFoldersGenerator {

  public MuleProjectFoldersGenerator(String groupId, String artifactId, PackagingType packagingType) {
    super(groupId, artifactId, packagingType);
  }

  @Override
  public void generate(Path targetFolder) {
    createFolderIfNecessary(targetFolder.toAbsolutePath().toString(), CLASSES.value());

    createFolderIfNecessary(targetFolder.toAbsolutePath().toString(), TEST_CLASSES.value());

    createFolderIfNecessary(targetFolder.toAbsolutePath().toString(), MULE.value());

    createFolderIfNecessary(targetFolder.toAbsolutePath().toString(), LIB.value());

    createFolderIfNecessary(targetFolder.toAbsolutePath().toString(), API.value());

    createFolderIfNecessary(targetFolder.toAbsolutePath().toString(), WSDL.value());

    createFolderIfNecessary(targetFolder.toAbsolutePath().toString(), MAPPINGS.value());

    createFolderIfNecessary(targetFolder.toAbsolutePath().toString(), TEST_MULE.value(), MUNIT.value());
  }
}