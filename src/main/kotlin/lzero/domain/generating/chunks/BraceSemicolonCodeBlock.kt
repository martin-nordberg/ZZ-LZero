//
// (C) Copyright 2018 Martin E. Nordberg III
// Apache 2.0 License
//

package lzero.domain.generating.chunks

//---------------------------------------------------------------------------------------------------------------------


class BraceSemicolonCodeBlock(chunks: List<ICodeChunk>) :
    AbstractCodeBlock() {

    init {
        for (chunk in chunks) {
            add(chunk)
        }
    }

    override fun getPrefix(density: ECodeDensity): String =
        when (density) {
            ECodeDensity.ALL_ONE_LINE      -> if (hasContent()) "{ " else "{"
            ECodeDensity.EXTRA_LINE        -> "{"
            ECodeDensity.NEW_LINE_PER_ITEM -> "{"
        }

    override fun getSeparator(density: ECodeDensity): String =
        when (density) {
            ECodeDensity.ALL_ONE_LINE      -> "; "
            ECodeDensity.EXTRA_LINE        -> "; "
            ECodeDensity.NEW_LINE_PER_ITEM -> ""
        }

    override fun getSuffix(density: ECodeDensity): String =
        when (density) {
            ECodeDensity.ALL_ONE_LINE      -> if (hasContent()) " }" else "}"
            ECodeDensity.EXTRA_LINE        -> "}"
            ECodeDensity.NEW_LINE_PER_ITEM -> "}"
        }

}
