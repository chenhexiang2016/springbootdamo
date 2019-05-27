package com.study.demo.word2vec;

import com.hankcs.hanlp.corpus.io.IOUtil;
import com.hankcs.hanlp.mining.word2vec.DocVectorModel;
import com.hankcs.hanlp.mining.word2vec.Word2VecTrainer;
import com.hankcs.hanlp.mining.word2vec.WordVectorModel;

import java.io.IOException;
import java.util.Map;

/**
 * 演示词向量的训练与应用
 *
 * @author hankcs
 */
public class Word2vec
{
    private static final String TRAIN_FILE_NAME = "C:/Users/chx/Desktop/test02";
    private static final String MODEL_FILE_NAME = "C:/Users/chx/Downloads/vector.txt";

    public static void main(String[] args) throws IOException
    {
        WordVectorModel wordVectorModel = trainOrLoadModel();

        // 文档向量
        DocVectorModel docVectorModel = new DocVectorModel(wordVectorModel);
        String[] documents = new String[]{
                "是的，怎么了",
                "不是我现在有点事",
                "晚点说",
                "你是哪里呀",
                "你们是骗子吧",
        };
        for (int i = 0; i < documents.length; i++)
        {
            docVectorModel.addDocument(i, documents[i]);
        }
        printNearestDocument("不是我现在有点事", documents, docVectorModel);
    }

    static void printNearest(String word, WordVectorModel model)
    {
        System.out.printf("\n                                                Word     Cosine\n------------------------------------------------------------------------\n");
        for (Map.Entry<String, Float> entry : model.nearest(word))
        {
            System.out.printf("%50s\t\t%f\n", entry.getKey(), entry.getValue());
        }
    }

    static void printNearestDocument(String document, String[] documents, DocVectorModel model)
    {
        printHeader(document);
        for (Map.Entry<Integer, Float> entry : model.nearest(document))
        {
            System.out.printf("%50s\t\t%f\n", documents[entry.getKey()], entry.getValue());
        }
    }

    private static void printHeader(String query)
    {
        System.out.printf("\n%50s          Cosine\n------------------------------------------------------------------------\n", query);
    }

    static WordVectorModel trainOrLoadModel() throws IOException
    {
        if (!IOUtil.isFileExisted(MODEL_FILE_NAME))
        {
            if (!IOUtil.isFileExisted(TRAIN_FILE_NAME))
            {
                System.err.println("语料不存在，请阅读文档了解语料获取与格式：https://github.com/hankcs/HanLP/wiki/word2vec");
                System.exit(1);
            }
            Word2VecTrainer trainerBuilder = new Word2VecTrainer();
            return trainerBuilder.train(TRAIN_FILE_NAME, MODEL_FILE_NAME);
        }

        return loadModel();
    }

    static WordVectorModel loadModel() throws IOException
    {
        return new WordVectorModel(MODEL_FILE_NAME);
    }


}