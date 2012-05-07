/*
 * Copyright 2010-2012 Julien Nicoulaud <julien.nicoulaud@gmail.com>
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
package net.nicoulaj.maven.plugins.checksum.test.unit.digest;

import net.nicoulaj.maven.plugins.checksum.digest.DigesterFactory;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.security.NoSuchAlgorithmException;

/**
 * Miscellaneous tests for the {@link net.nicoulaj.maven.plugins.checksum.digest.DigesterFactory} class.
 *
 * @author <a href="mailto:julien.nicoulaud@gmail.com">Julien Nicoulaud</a>
 * @see net.nicoulaj.maven.plugins.checksum.digest.DigesterFactory
 * @since 1.0
 */
public class ChecksumFactoryTest
{
    /**
     * Rule used to specify per-test expected exceptions.
     */
    @Rule
    public ExpectedException exception = ExpectedException.none();

    /**
     * Assert a {@link java.security.NoSuchAlgorithmException} is thrown when trying get the {@link
     * net.nicoulaj.maven.plugins.checksum.digest.FileDigester} for an unknown algorithm.
     *
     * @throws java.security.NoSuchAlgorithmException
     *          should never happen.
     */
    @Test
    public void testNoSuchAlgorithmExceptionThrownOnInvalidAlgorithm() throws NoSuchAlgorithmException
    {
        exception.expect( NoSuchAlgorithmException.class );
        DigesterFactory.getInstance().getFileDigester( "SHA-666" );
    }
}