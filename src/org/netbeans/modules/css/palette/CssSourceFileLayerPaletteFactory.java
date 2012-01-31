/*
 * NetBeans CSS Palette
 * 
 * The MIT License
 * 
 * Copyright (c) 2012 junichi11
 * 
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * 
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 * 
 */
package org.netbeans.modules.css.palette;

import java.io.IOException;
import javax.swing.Action;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.spi.palette.DragAndDropHandler;
import org.netbeans.spi.palette.PaletteActions;
import org.netbeans.spi.palette.PaletteController;
import org.netbeans.spi.palette.PaletteFactory;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;
import org.openide.util.datatransfer.ExTransferable;

/**
 *
 * @author junichi11
 */
public class CssSourceFileLayerPaletteFactory {
        public static final String CSS_PALETTE_FOLDER = "CssPalette"; // NO18N
        
        private static PaletteController palette = null;
        
        @MimeRegistration(mimeType = "text/x-css", service = PaletteController.class)
        public static PaletteController createPalette(){
                try {
                        if(null == palette)
                                palette = PaletteFactory.createPalette(
                                        CSS_PALETTE_FOLDER,
                                        new CssActions(),
                                        null,
                                        new CssDragAndDropHandler());
                        return palette;
                } catch (IOException ex) {
                        Exceptions.printStackTrace(ex);
                }
                return null;
        }

        private static class CssActions extends PaletteActions {

                @Override
                public Action[] getImportActions() {
                        return null;
                }

                @Override
                public Action[] getCustomPaletteActions() {
                        return null;
                }

                @Override
                public Action[] getCustomCategoryActions(Lookup lkp) {
                        return null;
                }

                @Override
                public Action[] getCustomItemActions(Lookup lkp) {
                        return null;
                }

                @Override
                public Action getPreferredAction(Lookup lkp) {
                        return null;
                }
        }

        private static class CssDragAndDropHandler extends DragAndDropHandler {

                public CssDragAndDropHandler() {
                        super(true);
                }

                @Override
                public void customize(ExTransferable et, Lookup lkp) {
                }
        }
}
