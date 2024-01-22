This program should be able to create coded messages without someone been able to read them.

This proccess is divided into three parts.

First, each uppercase or lowercase letter must be shifted three positions to the right, according to the ASCII table: letter 'a' should become letter 'd', letter 'y' must become the character '|' and so on. 

Second, each line must be reversed. 

Third, being reversed, all characters from the half on (truncated) must be moved one position to the left in ASCII. In this case, 'b' becomes 'a' and 'a' becomes '`'.

## Examples
| Input | Output |
| --- | --- |
| `Texto #3` | "3# rvzgV" |
| `abcABC1` | "1FECedc" |
| `vxpdylY .ph` | "ks. \\n{frzx" |
| `vv.xwfxo.fd` | "gi.r{hyz-xx" |
