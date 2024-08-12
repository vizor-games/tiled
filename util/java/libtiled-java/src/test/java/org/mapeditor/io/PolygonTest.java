/*-
 * #%L
 * libtiled
 * %%
 * Copyright (C) 2004 - 2021 Thorbjørn Lindeijer <thorbjorn@lindeijer.nl>
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */
package org.mapeditor.io;

import org.junit.Test;
import org.mapeditor.core.Group;
import org.mapeditor.core.Map;
import org.mapeditor.core.MapObject;
import org.mapeditor.core.ObjectGroup;
import org.mapeditor.core.ObjectGroupData;

import java.util.List;

import static org.junit.Assert.assertNotNull;

// временно отдельный класс для удобства ребейза
public class PolygonTest {
    @Test
    public void testPolygon() throws Exception {
        Map map = new TMXMapReader().readMap("src/test/resources/orthogonal-outside/orthogonal-outside.tmx");
        final ObjectGroup objectGroup = (ObjectGroup) map.getLayer(2);
        final MapObject mapObject = objectGroup.getObjects().get(2);
        assertNotNull("Polygon is null.", mapObject.getPolygon());
    }

    @Test
    public void testPolygon2() throws Exception {
        Map map = new TMXMapReader().readMap("src/test/resources/polygon-polyline.tmx");

        // disappeared on 1.7
//        final Group group = map.getGroup().get(0);
//        final List<ObjectGroupData> objectgroup = group.getObjectgroup();
//        final ObjectGroupData objectGroupData = objectgroup.get(0);
//        final MapObject mapObject1 = objectGroupData.getObjects().get(0);
//        assertNotNull("Polygon is null.", mapObject1.getPolygon());

        final Group group = (Group) map.getLayer(2);
        final ObjectGroup objectGroupData = (ObjectGroup) group.getLayers().get(0);
        final MapObject mapObject1 = objectGroupData.getObjects().get(0);
        assertNotNull("Polygon is null.", mapObject1.getPolygon());

        final ObjectGroup objectGroup = (ObjectGroup) map.getLayer(3);
        final MapObject mapObject = objectGroup.getObjects().get(0);
        // fails on 1.4.3 without patch
        assertNotNull("Polygon is null.", mapObject.getPolygon());
    }
}
