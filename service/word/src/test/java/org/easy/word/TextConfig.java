package org.easy.word;

import org.easy.word.entity.Word;
import org.easy.word.service.IWordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TextConfig {

    @Autowired
    IWordService wordService;

    @Test
    public void contextLoads()  {
        List<String> txtList = initList();
        List<Word> wordList = new ArrayList<>();
        for(String txt:txtList){
            Word word=new Word();
            word.setText(txt);
            wordList.add(word);
        }
        wordService.saveBatch(wordList);
    }

    private List<String> initList() {
        List<String> mList = new ArrayList<>();
        mList.add("\uD83D\uDC39\uD835\uDFDA\uD835\uDFD8\uD835\uDFDA\uD835\uDFD8\uD83D\uDC39");
        mList.add("鼠༲你༲好༲看༲");
        mList.add("\uD83D\uDC2D②⓪②⓪\uD83D\uDC2D");
        mList.add("今天 ■■■■■■□□□□ 57.2%");
        mList.add("♥️❤️\uD83D\uDC9C\uD83D\uDDA4\uD83E\uDDE1\uD83D\uDC9B\uD83D\uDC9A\uD83D\uDC99");
        mList.add("\uD83D\uDC95\uD83D\uDC9E\uD83D\uDC93\uD83D\uDC97\uD83D\uDC96\uD83D\uDC98\uD83D\uDC9D");
        mList.add("♡ Life+u＝sweet ♡");
        mList.add("\uD83C\uDF53ʜᴀ͟ᴘ͟ᴘ͟ʏ ᴠᴀʟᴇɴᴛɪɴᴇ's ᴅᴀʏ̆̈ ♥");
        mList.add("\uD835\uDD40 \uD835\uDD5D\uD835\uDD60\uD835\uDD67\uD835\uDD56 \uD835\uDD6A\uD835\uDD60\uD835\uDD66 \uD835\uDFDB\uD835\uDFD8\uD835\uDFD8\uD835\uDFD8");
        mList.add("\uD835\uDDD4\uD835\uDDF9\uD835\uDDF9 \uD835\uDE01\uD835\uDDF5\uD835\uDDEE\uD835\uDE01 \uD835\uDE06\uD835\uDDFC\uD835\uDE02 \uD835\uDDEE\uD835\uDDFF\uD835\uDDF2 \uD835\uDDF6\uD835\uDE00 \uD835\uDDEE\uD835\uDDF9\uD835\uDDF9 \uD835\uDE01\uD835\uDDF5\uD835\uDDEE\uD835\uDE01 \uD835\uDDDC'\uD835\uDDF9\uD835\uDDF9 \uD835\uDDF2\uD835\uDE03\uD835\uDDF2\uD835\uDDFF \uD835\uDC8F\uD835\uDC86\uD835\uDC86\uD835\uDC85.");
        mList.add("\uD835\uDDEA\uD835\uDDF2 \uD835\uDDEE\uD835\uDDFF\uD835\uDDF2 \uD835\uDDFA\uD835\uDDFC\uD835\uDE00\uD835\uDE01 \uD835\uDC82\uD835\uDC8D\uD835\uDC8A\uD835\uDC97\uD835\uDC86 \uD835\uDE04\uD835\uDDF5\uD835\uDDF2\uD835\uDDFB \uD835\uDE04\uD835\uDDF2'\uD835\uDDFF\uD835\uDDF2 \uD835\uDDF6\uD835\uDDFB \uD835\uDDF9\uD835\uDDFC\uD835\uDE03\uD835\uDDF2.");
        mList.add("\uD835\uDE45\uD835\uDE6A\uD835\uDE68\uD835\uDE69 \uD835\uDE6C\uD835\uDE56\uD835\uDE63\uD835\uDE63\uD835\uDE56 \uD835\uDE60͇\uD835\uDE5E͇\uD835\uDE68͇\uD835\uDE68͇ \uD83C\uDD68\uD83C\uDD5E\uD83C\uDD64");
        mList.add("♡ \uD835\uDE42\uD835\uDE5E\uD835\uDE6B\uD835\uDE5A \uD835\uDE6E\uD835\uDE64\uD835\uDE6A \uD835\uDE69\uD835\uDE5D\uD835\uDE5A \uD835\uDE57\uD835\uDE5A\uD835\uDE68\uD835\uDE69 \uD83C\uDF19ིྀ");
        mList.add("уσυ ωιℓℓ αℓωαуѕ вє му ℓσνє, му ℓσνє.");
        mList.add("\uD83C\uDF08♡ ᶫᵒᵛᵉᵧₒᵤ ☪︎✨");
        mList.add("♡⃝ \uD835\uDE91\uD835\uDE8A\uD835\uDE99\uD835\uDE99\uD835\uDEA2 \uD835\uDE8F\uD835\uDE8A\uD835\uDE9D\uD835\uDE91\uD835\uDE8E\uD835\uDE9B'\uD835\uDE9C \uD835\uDE8D\uD835\uDE8A\uD835\uDEA2. ◡̈ ☽⋆\n" +
                "谢⃐谢⃐您⃐让⃐我⃐有⃐了⃐无⃐条⃐件⃐的⃐退⃐路⃐\n" +
                "可⃐以⃐随⃐时⃐退⃐回⃐到⃐您⃐的⃐保⃐护⃐圈⃐");
        mList.add("✐. \uD835\uDE5B\uD835\uDE56\uD835\uDE69\uD835\uDE5D\uD835\uDE5A\uD835\uDE67'\uD835\uDE68 \uD835\uDE3F\uD835\uDE56\uD835\uDE6E 〰︎ \uD83C\uDF08·\uD83D\uDC6B·\uD83D\uDCF7\n" +
                "您的肩膀是我看世界的瞭望台\n" +
                "是您把我举过头顶看世界");
        mList.add("\uD83D\uDC68\uD83C\uDFFB\uD835\uDE77\uD835\uDE8A\uD835\uDE99\uD835\uDE99\uD835\uDEA2 \uD835\uDE75\uD835\uDE8A\uD835\uDE9D\uD835\uDE91\uD835\uDE8E\uD835\uDE9B'\uD835\uDE9C \uD835\uDE73\uD835\uDE8A\uD835\uDEA2\uD83C\uDFE0\uD83D\uDC95\n" +
                "¨̮✦—我最爱的帅老头 ʚ•͈⚇•͈ɞ");
        mList.add("\uD83E\uDD34ℓσνє уσυ ❤Father ✨\n" +
                "小时候最想要快快长大\n" +
                "而长大后希望你能慢慢变老再慢一点");
        mList.add("— \uD83D\uDC70 ❥❥❥❥❥ \uD83D\uDC75 —");
        mList.add("\uD83D\uDC51\uD83D\uDC51\uD83D\uDC51\n" +
                "\uD83D\uDC78\uD83D\uDC78\uD83D\uDC78");
        mList.add("\uD83D\uDC52⠂⠂⠂⠂⠂⠂⠂⠂⠂⠂⠂╮\n" +
                "\uD83D\uDC57各位美丽的仙女们\n" +
                "\uD83D\uDC84 节日快乐\n" +
                "\uD83D\uDC8D⠂⠂⠂⠂⠂⠂⠂⠂⠂⠂⠂╯");
        mList.add("✐.ɴɪᴄᴇ ᴅᴀʏ 〰︎");
        mList.add("ʚ\uD83E\uDDF8ྀིɞ︎");
        mList.add("\uD835\uDCDC\uD835\uDCEE\uD835\uDCFB\uD835\uDCFB\uD835\uDD02 \uD835\uDCD2\uD835\uDCF1\uD835\uDCFB\uD835\uDCF2\uD835\uDCFC\uD835\uDCFD\uD835\uDCF6\uD835\uDCEA\uD835\uDCFC ❄️ \uD83C\uDF84\uD83C\uDF81");
        mList.add("/\uD835\uDC68\uD835\uDC96\uD835\uDC88./");
        mList.add("\uD83C\uDD70\uD83C\uDD84\uD83C\uDD76 ❽");
        mList.add("\uD83C\uDD30\uD83C\uDD44\uD83C\uDD36 ⑧");
        mList.add("⁸/₈ Sᴀᴛᴜʀᴅᴀʏ");
        mList.add("\uD835\uDFE0/\uD835\uDFE0 \uD835\uDD4A\uD835\uDD52\uD835\uDD65\uD835\uDD66\uD835\uDD63\uD835\uDD55\uD835\uDD52\uD835\uDD6A");
        mList.add("\uD835\uDC76\uD835\uDC76\uD835\uDC7B\uD835\uDC6B |");
        mList.add("\uD835\uDE48\uD835\uDE4A\uD835\uDE4F\uD835\uDE3F |");
        mList.add("\uD83E\uDDE2: \uD83D\uDC55: \uD83D\uDC56: \uD83D\uDC5E: ");
        mList.add("ʚ \uD835\uDE5B\uD835\uDE56\uD835\uDE69\uD835\uDE5D\uD835\uDE5A\uD835\uDE67'\uD835\uDE68 \uD83C\uDD53\uD83C\uDD50\uD83C\uDD68 ɞ\n" +
                "你是坚韧的大树\n" +
                "也是温柔的阳光");
        mList.add("\uD83C\uDF08ℍ\uD835\uDD52\uD835\uDD61\uD835\uDD61\uD835\uDD6A \uD835\uDD68\uD835\uDD56\uD835\uDD56\uD835\uDD5C");
        mList.add("\uD835\uDC70 \uD835\uDC89\uD835\uDC90\uD835\uDC91\uD835\uDC86 \uD835\uDC9A\uD835\uDC90\uD835\uDC96 \uD835\uDC89\uD835\uDC82\uD835\uDC97\uD835\uDC86 \uD835\uDC82 \uD835\uDC74\uD835\uDC86\uD835\uDC93\uD835\uDC93\uD835\uDC9A \uD835\uDC6A\uD835\uDC89\uD835\uDC93\uD835\uDC8A\uD835\uDC94\uD835\uDC95\uD835\uDC8E\uD835\uDC82\uD835\uDC94");
        mList.add("\uD835\uDC7E\uD835\uDC89\uD835\uDC82\uD835\uDC95 \uD835\uDC85\uD835\uDC90 \uD835\uDC98\uD835\uDC86 \uD835\uDC94\uD835\uDC82\uD835\uDC9A \uD835\uDC95\uD835\uDC90 \uD835\uDC95\uD835\uDC89\uD835\uDC86 \uD835\uDC88\uD835\uDC90\uD835\uDC85 \uD835\uDC90\uD835\uDC87 \uD835\uDC85\uD835\uDC86\uD835\uDC82\uD835\uDC95\uD835\uDC89? \uD835\uDC75\uD835\uDC90\uD835\uDC95 \uD835\uDC95\uD835\uDC90\uD835\uDC85\uD835\uDC82\uD835\uDC9A.");
        mList.add("\uD835\uDE4B\uD835\uDE5E\uD835\uDE58\uD835\uDE68\uD835\uDE3C\uD835\uDE67\uD835\uDE69");
        mList.add("\uD83C\uDD78\uD83C\uDD7D\uD83C\uDD72\uD83C\uDD77\n" +
                "\uD83C\uDD81\uD83C\uDD74\uD83C\uDD73");
        mList.add("\uD835\uDDE1\uD835\uDDF6\uD835\uDDFB\uD835\uDE01\uD835\uDDF2\uD835\uDDFB\uD835\uDDF1\uD835\uDDFC");
        mList.add("\uD835\uDDE3\uD835\uDDF9\uD835\uDDEE\uD835\uDE06 \uD835\uDDE6\uD835\uDE01\uD835\uDDEE\uD835\uDE01\uD835\uDDF6\uD835\uDDFC\uD835\uDDFB");
        mList.add("\uD835\uDE17\uD835\uDE0C\uD835\uDE19\uD835\uDE0D\uD835\uDE0C\uD835\uDE0A\uD835\uDE1B \uD835\uDE0B\uD835\uDE10\uD835\uDE08\uD835\uDE19\uD835\uDE20");
        mList.add("\uD83D\uDD05HEᒪᒪO ᗩᑌGᑌᔕT 希望八月运气爆棚");
        mList.add("\uD835\uDC3B\uD835\uDC38\uD835\uDC3F\uD835\uDC3F\uD835\uDC42 \uD835\uDC68\uD835\uDC96\uD835\uDC88\uD835\uDC96\uD835\uDC94\uD835\uDC95 | 愿下半年一切安好\uD83C\uDF3C");
        mList.add("\uD83C\uDF33≋≋ \uD83C\uDFE1 \uD83C\uDF43 夏天的风暖暖的吹过");
        mList.add("\uD83C\uDF47葡萄成熟时");
        mList.add("ᵕ̈ ɴɪᴄᴇ \uD83C\uDF35 ᵕ̈દ ᵕ̈ ૩ \uD83C\uDFD6\n" +
                "⛅\uD83C\uDF7B\uD83C\uDF67\uD83C\uDF49\uD83C\uDF53\uD83C\uDF4D\uD83C\uDF52\uD83C\uDF47\uD83C\uDF48\uD83C\uDF4E\n" +
                "没̻ 有̻ 西̻ 瓜̻ 冰̻ 淇̻ 淋̻ 的̻ 夏̻ 天̻ 不̻ 完̻ 美̻");
        mList.add("♡✈ ♡ \uD83C\uDFD6 ♡ \uD83D\uDE97 ♡ \uD83D\uDE8A♡⛵ ♡\n" +
                "\uD83C\uDF08h a v e  a  s w e e t  d a y\uD83C\uDF3B\n" +
                "整⃙ 个⃙ 夏⃙ 天⃙ 想⃙ 环⃙ 游⃙ 世⃙ 界⃙");
        mList.add("\uD83D\uDE99 ╭══╮ ╭═══════╮\n" +
                "  ╭╯整个夏天 ║想和你环游世界\n" +
                "  ╰⊙ ═ ⊙╯ ╰═⊙═⊙══⊙╯");
        mList.add("  ʚ◡̈⃝ɞ 整个夏天想和你环游全世界\uD83C\uDF43\n" +
                "\n" +
                "╭ ◜◝ ͡  ◜◝╮\n" +
                "(   ⸝⸝⸝⁰⃚⃙̴ ༝ ⁰⃚⃙̴⸝⸝⸝  )\n" +
                "╰◟◞  ͜   ◟◞╯\n" +
                "日子有盼头 生活才可爱 ฅ՞•ﻌ•՞ฅ\n" +
                "\n" +
                "☁️ 今天天气是晴，心情是想你๑⃙⃘´༥`๑⃙⃘\n" +
                "\n" +
                "今日限定 \uD83D\uDC9B本人全糖去冰 ” દ ᵕ̈ ૩وً");
        mList.add("\uD83C\uDD52\uD83C\uDD50\uD83C\uDD5C \uD83C\uDD51\uD83C\uDD5E\uD83C\uDD68");
        mList.add("♡+♡=♡²");
        mList.add("(｡・//ε//・｡)");
        mList.add("(　ﾟ∀ﾟ) ﾉ♡\n" +
                "\n" +
                "ヾ(●゜▽゜●)♡ \n" +
                "\n" +
                "Σ>―(〃°ω°〃)♡→\n" +
                "\n" +
                "ε٩(๑> ₃ <)۶з");
        mList.add("≧〔゜゜〕≦\n" +
                "\n" +
                "( ´(00)`)\n" +
                "\n" +
                "ヾ(；ﾟ(OO)ﾟ)ﾉ\n" +
                "\n" +
                "(❍ᴥ❍ʋ)\n" +
                "\n" +
                "／/( ◕‿‿◕ )＼");
        mList.add("(￣ヘ￣;)\n" +
                "\n" +
                "(-_-;)\n" +
                "\n" +
                "(-_-メ)\n" +
                "\n" +
                "(~_~;)\n" +
                "\n" +
                "(๐•̆ ·̭ •̆๐)");
        mList.add("(っ˘̩╭╮˘̩)っ\n" +
                "\n" +
                "(｡•́︿•̀｡)\n" +
                "\n" +
                "༼;´༎ຶ \u06DD ༎ຶ༽\n" +
                "\n" +
                "｡:ﾟ(;´∩`;)ﾟ:｡\n" +
                "\n" +
                "(个_个)\n" +
                "\n" +
                "(´°̥̥̥̥̥̥̥̥ω°̥̥̥̥̥̥̥̥｀)");

        return mList;
    }





}
