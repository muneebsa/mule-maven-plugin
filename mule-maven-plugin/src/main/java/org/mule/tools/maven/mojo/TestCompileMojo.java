/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tools.maven.mojo;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;
import org.mule.tools.api.packager.sources.MuleContentGenerator;

import java.io.IOException;

/**
 * @author Mulesoft Inc.
 * @since 3.1.0
 */
@Mojo(name = "test-compile",
    defaultPhase = LifecyclePhase.TEST_COMPILE,
    requiresDependencyResolution = ResolutionScope.RUNTIME)
public class TestCompileMojo extends AbstractMuleMojo {

  @Override
  public void doExecute() throws MojoExecutionException, MojoFailureException {
    getLog().debug("Compiling test source code...");
    try {
      ((MuleContentGenerator) getContentGenerator()).createTestFolderContent();
    } catch (IllegalArgumentException | IOException e) {
      throw new MojoFailureException("Fail to compile sources", e);
    }
  }

  @Override
  public String getPreviousRunPlaceholder() {
    return "MULE_MAVEN_PLUGIN_TEST_COMPILE_PREVIOUS_RUN_PLACEHOLDER";
  }
}